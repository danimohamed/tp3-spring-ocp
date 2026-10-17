# TP 3 : Spring IoC & OCP — Stratégies d'injection et sélection d'implémentations

Le principe Ouvert/Fermé (OCP) impose de pouvoir changer de source de données **sans jamais modifier `MetierImpl`**.
Toute la logique de sélection est externalisée dans la configuration Spring.

## Structure du projet : packages `dao`, `metier`, `config` et point d'entrée `Main`
![Structure du projet](images/structure.png)

## Stratégie A — `@Primary` : `DaoImpl` est choisie par défaut → `Resultat final = 200.0`
![Stratégie @Primary](images/execution.png)

## Le problème de l'ambiguïté : sans `@Primary`, Spring lève `NoUniqueBeanDefinitionException` (3 candidats)
![Ambiguïté d'injection](images/ambiguite.png)

## Stratégie B — alias `@Bean @Primary` : le conteneur pointe vers `DaoApi` → `Resultat = 440.0`
![Stratégie alias @Bean](images/alias.png)

## Stratégie C — propriété externe `dao.target=dao2` lue par `@Value` → `Resultat = 300.0`
![Stratégie propriétés externes](images/proprietes.png)

## Profils Spring : le profil `prod` enregistre `daoProfilProd` (5 beans `IDao` au lieu de 4)
![Profils Spring](images/profils.png)

## Injection multiple : `List<IDao>` et `Map<String, IDao>` — somme des 4 sources → `650.0`
![Injection multiple de DAO](images/multidao.png)

## Tests de non-régression : `Tests run: 15, Failures: 0, Errors: 0` — `BUILD SUCCESS`
![Tests unitaires](images/tests.png)