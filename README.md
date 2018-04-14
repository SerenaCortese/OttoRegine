Data una schacchiera 8x8
posizionare 8 regine degli scacchi
in modo che non si possano mangiare tra di loro (non nella stessa riga, non nella stessa colonna e non in diagonale)

```
|---|---|---|---|
|   | Q |   |   |	riga 0: colonna 1
|---|---|---|---|
|   |   |   | Q |	riga 1: colonna 3
|---|---|---|---|
| Q |   |   |   |	riga 2: colonna 0
|---|---|---|---|
|   |   | Q |   | 	riga 3: colonna 2
|---|---|---|---|
```


Soluzione parziale= lista di numeri (colonne) tra 0 e N-1 che non si devono ripetere 

Soluzione totale= soluzione parziale con esattamente N elementi (righe)

La soluzione parziale viene costruita aggiungendo una nuova regina per volta, nella riga successiva. Metterò la regina nella riga==livello.
Le mosse possibili ad un certo livello dipendono da quali caselle sono "libere" dall'attacco delle regine poste nelle righe (livelli) precedenti.
Bisogna mettere solo una regina per riga, per cui dovrò solo memorizzarne la posizione(colonna occupata).

Una volta trovata la prima soluzione, la ricerca può terminare. Non voglio tutte le possibili soluzioni (come l'espansione) qui me ne basta una (algoritmo di ricerca).