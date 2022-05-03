package hr.unidu.oop.p09;

import java.awt.BorderLayout;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class Brojac extends JFrame {
    private boolean isStarted = false;
    private JLabel counterLabel = new JLabel("  0  ");
    private SwingWorker<Integer, Integer> worker;
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
 
    public Brojac() {
    	 // Obrada se pokreće nakon klika na gumb Start
    	 startButton.addActionListener(e -> {
    		 if(!isStarted) { 
    			// Stvara se i pokreće radna dretva
    			worker = new Radnik(Integer.valueOf(counterLabel.getText().trim()));
    	        worker.execute();
    	        isStarted = true;
    	     }
    	 });
    	 stopButton.addActionListener(e -> {
    		// Ako je obrada prethodno pokrenuta, obrada se prekida nakon klika na gumb Start
    		 if(isStarted) { 
    			 worker.cancel(true);
    			 isStarted = false;
    			 worker = null;
    	     }
    	 });

         add(startButton, BorderLayout.WEST);
         add(counterLabel, BorderLayout.CENTER);
         add(stopButton, BorderLayout.EAST);
         pack();
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);
    }

    class Radnik extends SwingWorker<Integer, Integer> {
        int counter = 0;
        public Radnik(int c) {
        	counter = c;
        }
        @Override
        protected Integer doInBackground() throws Exception {
        	// Broji u petlji
            while(true) {
                counter++;
                // Objavi novi broj
                publish(counter);
                Thread.sleep(60);
                // Je li dretva prekinuta? Ako je, prekini obradu.
                if (isCancelled()) { // metoda vraća true ako je dretva prekinuta (pozvana metoda cancel() na dretvi)
                    System.out.println("Dretva je prekinuta");
                    break;
                }
            }
            return counter;
        }

        @Override
        protected void process(List<Integer> chunk) {
            // Prikaži zadnji primljeni rezultat
            Integer counterChunk = chunk.get(chunk.size()-1);
            counterLabel.setText(counterChunk.toString());
        }
        // Objava konačnih rezultata
        @Override
        public void done() {
        	try {
        		Integer i = get();
        		counterLabel.setText(i.toString());
            } catch (ExecutionException | InterruptedException e) {
                 e.printStackTrace();
            } catch (CancellationException e){
            	 System.out.println("Dretva je prekinuta");
            }
            	
       	
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Brojac();
            }
        });
    }
}