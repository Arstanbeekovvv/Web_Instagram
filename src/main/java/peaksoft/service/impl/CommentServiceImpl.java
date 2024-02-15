package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl {
    private final CommentRepository commentRepository;
}
