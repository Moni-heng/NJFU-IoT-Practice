package com.nl.teaching.controller;

import com.nl.teaching.service.IInteractionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interactionQuestion")
public class InteractionQuestionController {

    @Autowired
    public IInteractionQuestionService interactionQuestionService;

}
