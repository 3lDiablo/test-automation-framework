#language:fr
#Auteur: gromdhane@iaaucarre.com
Fonctionnalité: : En tant qu'admnistrateur je voudrait me connecter au back office Momi

  @momi_bo_login_page
  Scénario: : Login with admin credentials
    Etant donné  Un administrateur ouvre la page d'acceuil du back office Momi
    Lorsque l'il saisie ses identifiants correctement
    Et qu'il clique sur le bouton "se connecter"
    Alors il accède au back office Momi et visualise la liste des membres Momi
