StockExchange este implementat ca un Singleton, asigurându-se că există o singură instanță a bursei de valori.

StockTradingFacade oferă o interfață simplificată și unificată pentru subsistemele complexe legate de tranzacționarea, iar UserManagementFacade  pentru subsistemele complexe legate de gestionarea utilizatorilor

Proxy Pattern a fost folosit pentru menținerea un istoric al tranzacțiilor.

Observer trimite feedback la toate modificările legate cu stockuri

Metoda Factory a oferit posibilitatea de a crea stocuri

StockTradingTemplate, definește un schelet și conține trei metode care poate fii încorporate în acesta pentru vânzarea și cumpărarea de stockurilor

La Strategy pattern putem alege între operațiune de DayTradingStrategy și LongTermInvestingStrategy.

ExternalStock care reprezintă acțiuni dintr-o sursă externă., cu Adapter utilizăm aceste stocuri în sistem inițial
