#language:fr
#Auteur: gromdhane@iaaucarre.com
Fonctionnalité: : En tant qu'admnistrateur je voudrais me connecter au back office Momi

  @momi_bo_login_page
  Scénario: : Login with admin credentials
    Etant donné  Un administrateur ouvre la page d'acceuil du back office Momi
    Lorsqu'l'il saisie ses identifiants correctement
    Et qu'il clique sur le bouton SE CONNECTER
    Alors il accède au back office Momi et visualise la liste des membres Momi
