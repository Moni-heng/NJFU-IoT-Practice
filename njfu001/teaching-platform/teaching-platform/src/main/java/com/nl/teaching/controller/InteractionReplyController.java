package com.nl.teaching.controller;

import com.nl.teaching.service.IInteractionReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interactionReply")
public class InteractionReplyController {

    @Autowired
    public IInteractionReplyService interactionReplyService;

}
