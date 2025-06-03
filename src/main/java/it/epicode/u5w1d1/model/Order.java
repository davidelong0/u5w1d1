package it.epicode.u5w1d1.model;

import it.epicode.u5w1d1.enumeration.StatoOrdine;
import it.epicode.u5w1d1.enumeration.StatoTavolo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int contatore = 1;

    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private List<Item> items;
    private Table tavolo;
    private double costoCoperto; // ora non hardcoded, viene passato da fuori

    public Order(int numeroCoperti, Table tavolo, double costoCoperto) {
        this.numeroOrdine = contatore++;
        this.stato = StatoOrdine.IN_CORSO;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalTime.now();
        this.items = new ArrayList<>();
        this.tavolo = tavolo;
        this.costoCoperto = costoCoperto;
        this.tavolo.setStato(StatoTavolo.OCCUPATO); // imposta tavolo occupato all'ordine
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotale() {
        double totaleItems = items.stream().mapToDouble(Item::getPrice).sum();
        return totaleItems + (numeroCoperti * costoCoperto);
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordine #").append(numeroOrdine).append("\n")
                .append("Stato: ").append(stato).append("\n")
                .append("Tavolo: ").append(tavolo.getNumero()).append("\n")
                .append("Coperti: ").append(numeroCoperti).append(" (€").append(costoCoperto).append(" cadauno)\n")
                .append("Ora acquisizione: ").append(oraAcquisizione).append("\n")
                .append("Elementi ordinati:\n");

        for (Item item : items) {
            sb.append("- ").append(item.getName())
                    .append(" (€").append(String.format("%.2f", item.getPrice())).append(")\n");
        }

        sb.append("Totale: €").append(String.format("%.2f", getTotale()));
        return sb.toString();
    }
}
