package com.example.demo.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TestSession;

@Service
public class SessionService {

    // セッションIDをキーにしてセッション情報を保持
    private final Map<String,TestSession> sessionMap = new ConcurrentHashMap<>();

    // セッションを保存
    public void save(TestSession session) {
        sessionMap.put(session.getSessionId(), session);
    }

    // セッションIDからセッションを取得
    public Optional<TestSession> findBySessionId(String sessionId) {
        return Optional.ofNullable(sessionMap.get(sessionId));
    }

    // セッションを削除（任意）
    public void remove(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // セッションが存在するか確認（任意）
    public boolean exists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}