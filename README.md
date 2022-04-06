# EngagementApp
En Open Liberty/Micro Profile web app för ett "Pattern matching" demo för att demonstrera och diskutera Javas Project Amber och Pattern matching.

Repot har tre taggade commits som används likt en "tv-kock" för att hoppa fram och tillbaks i möjligheterna som Project Amber har levererat mellan Java 11 och Java 17 (preview).
## Installation
NB! Rätt Java version krävs (17 eller 11).

NB2! En backend service krävs för att få resultat på endpointen (se t.ex. min AccountService på GitHub).

Bygg och kör: `./mvnw liberty:run`

Endpoint: `http://localhost:9080/engagement-app/api/engagement/account/0`
