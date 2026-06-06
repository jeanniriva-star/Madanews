package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Notification;
import com.madanews.madanewsapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/utilisateur/{id}")
    public List<Notification>
    getNotificationsUtilisateur( @PathVariable Long id) {

        return notificationService.getNotificationsUtilisateur(id);
    }

    @PutMapping("/{id}/lu")
    public Notification marquerCommeLue(@PathVariable Long id) {

        return notificationService.marquerCommeLue(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerNotification(@PathVariable Long id) {

        notificationService.supprimerNotification(id);
    }
}