package it.epicode.u5w1d1.model;

import it.epicode.u5w1d1.enumeration.StatoTavolo;

public class Table {
    private int numero;
    private int numeroCopertiMax;
    private StatoTavolo stato;

    public Table(int numero, int numeroCopertiMax, StatoTavolo libero) {
        this.numero = numero;
        this.numeroCopertiMax = numeroCopertiMax;
        this.stato = StatoTavolo.LIBERO; // default libero
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroCopertiMax() {
        return numeroCopertiMax;
    }

    public void setNumeroCopertiMax(int numeroCopertiMax) {
        this.numeroCopertiMax = numeroCopertiMax;
    }

    public StatoTavolo getStato() {
        return stato;
    }

    public void setStato(StatoTavolo stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Tavolo #" + numero + " (" + numeroCopertiMax + " coperti) Stato: " + stato;
    }
}
