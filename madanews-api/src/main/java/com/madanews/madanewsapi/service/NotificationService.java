package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.entity.Notification;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification creerNotification(
            Utilisateur utilisateur,
            String titre,
            String message
    ) {

        Notification notification = new Notification();

        notification.setTitreNotif(titre);
        notification.setMessage(message);
        notification.setDateEnvoi( LocalDateTime.now());
        notification.setLu(false);
        notification.setUtilisateur(
                utilisateur );

        return notificationRepository.save( notification );
    }

    public List<Notification>
    getNotificationsUtilisateur( Long idUtilisateur) {
        return notificationRepository.findByUtilisateur_IdUtilisateursOrderByDateEnvoiDesc(
                        idUtilisateur);
    }

    public Notification marquerCommeLue( Long idNotification) {
        Notification notification = notificationRepository.findById( idNotification )
                        .orElseThrow(() -> new RuntimeException( "Notification introuvable"));
        notification.setLu(true);
        return notificationRepository.save( notification);
    }

    public void supprimerNotification( Long idNotification) {
        notificationRepository.deleteById(idNotification);
    }
}