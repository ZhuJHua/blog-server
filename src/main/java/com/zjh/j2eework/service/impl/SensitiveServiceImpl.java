package com.zjh.j2eework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjh.j2eework.dao.mapper.SensitiveMapper;
import com.zjh.j2eework.entity.SensitiveWord;
import com.zjh.j2eework.service.SensitiveService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description Sensitive service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@Service
public class SensitiveServiceImpl extends ServiceImpl<SensitiveMapper, SensitiveWord> implements SensitiveService {
    
    private final SensitiveWordFilter sensitiveWordFilter;
    private final SensitiveMapper sensitiveMapper;
    
    public SensitiveServiceImpl(SensitiveMapper sensitiveMapper) {
        this.sensitiveMapper = sensitiveMapper;
        
        sensitiveWordFilter = new SensitiveWordFilter();
        
    }
    
    @Override
    public void initSensitiveMap() {
        Set<String> sensitiveWords = sensitiveMapper.getSensitiveWord();
        for (String word : sensitiveWords) {
            sensitiveWordFilter.addSensitiveWord(word);
        }
    }
    
    @Override
    public boolean containsSensitiveWord(String text) {
        initSensitiveMap();
        return sensitiveWordFilter.containsSensitiveWord(text);
    }
    
    @Override
    public void addSensitive(SensitiveWord sensitive) {
        save(sensitive);
    }
    
    @Override
    public void delSensitive(String name) {
        sensitiveMapper.delSensitiveWord(name);
    }
    
    @Override
    public Set<String> getWordList() {
        return sensitiveMapper.getSensitiveWord();
    }
    
    private static class SensitiveWordFilter {
        //状态转移表
        private final Map<Integer, Map<Character, Integer>> transition;
        //结束状态集合
        private final Set<Integer> sensitiveStates;
        
        public SensitiveWordFilter() {
            transition = new HashMap<>();
            sensitiveStates = new HashSet<>();
        }
        
        public void addSensitiveWord(String word) {
            int currentState = 0;
            for (char c : word.toCharArray()) {
                transition.putIfAbsent(currentState, new HashMap<>());
                if (!transition.get(currentState).containsKey(c)) {
                    transition.get(currentState).put(c, transition.size());
                }
                currentState = transition.get(currentState).get(c);
            }
            sensitiveStates.add(currentState);
        }
        
        public boolean containsSensitiveWord(String text) {
            int currentState = 0;
            for (char c : text.toCharArray()) {
                if (transition.containsKey(currentState) && transition.get(currentState).containsKey(c)) {
                    currentState = transition.get(currentState).get(c);
                    if (sensitiveStates.contains(currentState)) {
                        return true;
                    }
                } else {
                    currentState = 0;
                }
            }
            return false;
        }
    }
}
