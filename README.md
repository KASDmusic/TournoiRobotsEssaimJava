
***
Dans un espace donné, un nombre X de robots ainsi qu'une balise sont disposés aléatoirement.
Le principe est de désamorcer la balise le plus rapidement possible.
Seulement, chaque robot doit fonctionner avec le même code.
Vous devez donc adapter votre logique pour qu'un même code agisse intelligement en fonction de chaques circonstances !
***
#### Informations supplémentaires

* Chaque Robot dispose d'une portée grâce à laquelle il peut soit désamorcer la balise, soit communiquer des informations avec d'autres robots.
* Chaque robot stocke automatiquement les coordonnées de la balise si ils la croisent.
* Chaque robot communique automatiquement les coordonnées de la balise aux autres robots si il l'a déjà croisé.

Utilisez donc ces informations pour créer un code dynamique ! (D'autres sont également disponibles)


## Architecture

L'architecture logicielle mis en place est **SOA** *(Service Oriented Architecture)* en respectant au mieux les règles d'élégance du code *(clean code)* et *S.O.L.I.D.*.

## Environnement

Ce projet est réalisé en **Java 11** *(OpenJDK)*. et **Jakarta EE 8**.
Il utilise l'outil **Maven** en version 3.6.2.

### Exécution

Récupération du projet:
~~~
    git clone https://github.com/ZelmoTheDragon/whiteapp.git
    cd whiteapp
    mvn install
~~~

> En savoir plus sur la licence [CeCILL](http://cecill.info/index.fr.html)

* Les technologies Jakarta EE
* La structure d'un projet type *EAR*
* Le serveur d'application Payara et Payara Micro
