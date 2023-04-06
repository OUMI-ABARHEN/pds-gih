integration des codes de Oumaima Abarhen, Marouan Aghbalou, et Ahmed El Ghassib.



creer database avec le nom pds.
changer username et password dans persistence.xml
run la class app dans backend pour remplire bd.
run la class server.
changer les paths des icons dans les lignes 32(icon greenBed.png) et 34(icon redBed.png) de la class ma.uiass.eia.pds.frontend.Table.TableActionCellRender 
changer le path des icons dans la ligne 48 de la class ma.uiass.eia.pds.frontend.Test.model.Model_Menu (doit etre de la forme /.../icon/)
(vous pouvez trouver les paths des icons dans resources)
1- Run la class package ma.uiass.eia.pds.frontend.MainLogin.MainLogin [username: ID001, password: admin] pour tester la securite (vous allez etre diriger vers l'ihm de chef de service)
maintenant vous pouvez tester les uc:
-Demander un lit et consulter les demandes d'un service:
pour supprimer un detaildemande appuier sur le detail qui se trouve dans la tabe apres appuier sur le boutton supprimer
pour consulter les details d'une demande appuier sur le numero demande

-Grerer les reservations 
une fois dans l'interface Sejour vous pourrez faire ce qui suit :
-Ajouter un Séjour : Vous pouvez entrer les Dates (date entrée et date sortie) en sélectionnant une date dans le calendrier, puis vous choisirez un des objets Lit avec l'état (Disponible) dans la base de données à partir de la comboBox intitulée Codes Lits et en cliquant sur le bouton Ajouter un séjour, le séjour sera enregistré dans la base de données.
-Load Sejours : en cliquant sur le bouton vous obtiendrez tous les objets Sejour en cours dans la base de données dans un tableau à droite
-Mettre à jour le séjour : si vous souhaitez modifier la (date de sortie) d'un séjour dans le tableau, vous sélectionnez la ligne du séjour que vous souhaitez modifier et entrez la nouvelle_date_sortie, puis en cliquant sur le bouton de mise à jour, le séjour sélectionné sera mis à jour et vous pouvez afficher ce changement en cliquant sur le bouton charger
Et noter qu'il ya un processus automatique qui so lance dans le back-end qui verifie quand la date sortie d'un sejour est la meme que la date du système ,si c'est vrai ce sejour lié à un lit il va devenir null et l' etat de lit va devenir Disponible.
et d'autre part en ajoutant un sejour à un lit son etat devient Occupé.

-Mettre à jour l’état d’un lit:
une fois vous avez dans consulter lits vous pouvez voir les etats des lits sous forme de lit vert pour les lits disponible  et rouge pour occupe
une fois vous ajoutez un sejour et vous revenez vers consulter les lits vous trouver les updated


2- Run la class ma.uiass.eia.pds.frontend.Test.main.MainLogistique pour visualiser l'uc Gerer les commandes d’approvisionnement de l'admin logistique 

