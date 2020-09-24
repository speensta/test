package com.example.test.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<Map<String, Object>> getBoards() throws Exception;
}
