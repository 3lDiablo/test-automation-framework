#language:fr
#Auteur: gromdhane@iaaucarre.com
Fonctionnalité: : En tant qu'admnistrateur je voudrais me déconnecter du back office Momi

  Contexte: Un admin est connecté
    Etant donné  Un administrateur ouvre la page d'acceuil du back office Momi
    Lorsqu'l'il saisie ses identifiants correctement
    Et qu'il clique sur le bouton SE CONNECTER
    Alors il accède au back office Momi et visualise la liste des membres Momi


  @momi_bo_logout
  Scénario: : Se déconnecter du Back Office après s'être connecté
    Lorsqu'un administrateur clique sur le menu de l'utilisateur
    Et qu'il clique sur le bouton Déconnexion
    Alors il se déconnecte et est renvoyé sur la page d'authentification
