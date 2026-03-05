# Melody Generator
Java library that generates a complete melody as follows:

1. The notes are generated randomly. The 7 notes are do, re, mi, fa, sol, la, and si.
2. A melody is made up of a number of notes between 4 and 28, and always a multiple of 4.
3. Every group of 4 notes forms a measure and must be separated from the next measure using a bar "|".
4. The end of the melody is marked with two bars "||".
5. The first and last notes of the melody match.

Example 1:
```
do mi fa mi | si do sol fa | fa re si do | sol mi re do ||
```

Example 2:
```
la re mi sol | fa mi mi si | do la sol fa | fa re si sol | do sol mi re | fa la do la ||
```
