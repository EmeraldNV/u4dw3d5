Come specificato nello screen di drawSQL, ho preferito usare la il JOINED TABLE per mantere le tabelle pulite oltre ad essere la scelta migliore per i metodi
che volevo implementare. Inoltre evito i null nei campi non in comune tra le tabelle. Consiste in 5 tabelle come risultato. Come nota ho optato di mettere il
tipo dell id come Long invece di UUID poiche' non sono molto pratico con UUID e in quanto e' poco usato in ambito lavorativo da quanto ne so. Per ovviare cio' ho
modificato il campo nel db e ho messo constraints -> identity > always alla primary key. Ho messo anche per la tessera un integer. Le relazioni sono tutte 1 a 1,
tranne che le relazioni tra il prestito (many) e Utente e Catalogo (to one).
Come scritto in drawSql: un libro/rivista e' contenuto in un catalogo. Questo catalogo puo' essere data in prestito ad un utente. Utente puo fare piu prestiti.
piu prestiti contengono un catalogo.