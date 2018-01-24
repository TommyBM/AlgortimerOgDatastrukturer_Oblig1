/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paranoid
 */
import java.util.Arrays;
import java.util.NoSuchElementException;
public class Oblig1 {
  
    // Oppgave 1
    /* Skal retunere den minste verdien i parametertabellen A */
    private Oblig1() {}
    
    public static int min(int[] a)
    {
        if(a.length < 1)
        {
            throw new NoSuchElementException("Tabell A er tom!");
        }
       for(int i = a.length - 1; i > 0; i--)
       {
           if(a[i] == a[i - 1])
           {
               bytt(a, i, i - 1);
           }
       }
        return a[0];
            
    }
    private static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static int ombytting(int[] a)
    {
        int antall = 0;
        for(int i = a.length - 1; i > 0; i--)
       {
           if(a[i] == a[i - 1])
           {
               bytt(a, i, i - 1);
               antall++;
           }
       }
       return antall; 
    }
    // Oppgave 2
    /* Metoden skal retunere modus av en sortert tabell */
    
    public static int modus1(int[] a)
    {
       if(a.length < 1)
       {
           throw new IllegalStateException("Tabell A er tom!");
       }
       else
           if(!erSortert(a))
           {
               throw new IllegalStateException("Tabell A er ikke sortert");
           }
       
       int modus = 0;
       int modusTeller = 0;
       int tempModus = a[0];
       int tempTeller = 1;
       
       for(int i = 1; i < a.length; i++)
       {
          if(a[i] == tempModus)
          {
              tempTeller++;
          }
          else
          {
                  if(tempTeller > modusTeller)
                  {
                  modus = tempModus;
                  modusTeller = tempTeller;
                  }
                  tempModus = a[i];
                  tempTeller = 1;
          }
       }
       if(tempTeller > modusTeller)
       {
           return tempModus;
       }
       else
       {
           return modus;
       }
    }
    private static boolean erSortert(int[] a)
    {
        for(int i = 1; i < a.length; i++ )
        {
            if(a[i - 1] == a[i])
            {
               return true;
            }
        }
        return false;
    }
    //Oppgave 3
    /* Metoden skal modus av en tabell */
    public static int modus2(int[] a)
    {
    if(a.length < 1)
    {
       throw new IllegalStateException("Tabell A er tom!");
    }
    int modus = a[0];
    int modusTeller = 0;
    
    for(int i = 0; i < a.length; i++)
    {
       if(a[i] != modus && a.length - i > modusTeller)
      {
      int midlertidig = a[i];
      int midlertidligTeller = 1;
      
      for(int j = i + 1; i < a.length; i++)
      {
          if(a[j] == midlertidig)
          {
              midlertidligTeller++;
          }
      }
      
       if(midlertidligTeller > modusTeller)
       {
           modus = midlertidig;
           modusTeller = midlertidigTeller;
           
       }
      }
      
    }
   // Dersom det er flere alternativer til modulus, er det den første som blir
   // returnert
   
    return modus;
    }
    
   // Oppgave 4
   /* 
   Metoden skal dele paramtertabellen A i to sorterte deler
   Venstre del skal inneholde oddetallene
   Høyre del skal inneholde partallene
   */
    
    public static void delsortering(int[] a)
    {
        int v = 0, h = a.length - 1;
        while( v < a.length && (a[v] & 1) != 0) v++; // finner oddetall fra v
        while(h >= 0 && (a[h] & 1) == 0) h--;        // finenr partall fra h
    while(true)
    {
        if(v < h) bytt(a,v++,h--); else break;
        while((a[v] & 1) != 0) v++;
        while((a[h] & 1) == 0) h--;
    }
    Arrays.sort(a, 0, v); // sorterer oddetall på venstre side
    Arrays.sort(a, v, a.length);
    
             
            
    }
   
    }
    
