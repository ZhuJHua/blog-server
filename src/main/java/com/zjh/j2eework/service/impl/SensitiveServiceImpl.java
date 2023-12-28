package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.jpa.JpaSensitiveRepository;
import com.zjh.j2eework.entity.SensitiveWord;
import com.zjh.j2eework.service.SensitiveService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description Sensitive service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@Service
public class SensitiveServiceImpl implements SensitiveService {
    
    private final JpaSensitiveRepository jpaSensitiveRepository;
    private final SensitiveWordFilter sensitiveWordFilter;
    
    public SensitiveServiceImpl(JpaSensitiveRepository jpaSensitiveRepository) {
        this.jpaSensitiveRepository = jpaSensitiveRepository;
        sensitiveWordFilter = new SensitiveWordFilter();
        
    }
    
    @Override
    public void initSensitiveMap() {
        Set<String> sensitiveWords = jpaSensitiveRepository.findAllDistinctContents();
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
        jpaSensitiveRepository.save(sensitive);
    }
    
    @Override
    public void delSensitive(String name) {
        jpaSensitiveRepository.deleteSensitiveWord(name);
    }
    
    @Override
    public Set<String> getWordList() {
        return jpaSensitiveRepository.findAllDistinctContents();
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
