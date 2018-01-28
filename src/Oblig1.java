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
       int modusteller = 0;
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
            if(a[i - 1] > a[i])
            {
               return false;
            }
        }
        return true;
    }
    //Oppgave 3
    /* Metoden skal modus av en tabell som ikke trenger å være sortert*/ 
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
           modusTeller = midlertidligTeller;
           
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
        while( v < a.length && (a[v] & 1) != 0) v++; 
        // looper til vi finner oddetall fra v
        while(h >= 0 && (a[h] & 1) == 0) h--;        
        // looper til vi finner partall fra h
        
    while(true)
    {
        if(v < h) bytt(a,v++,h--); else break;
        // bytter plass på odetall og partall
        while((a[v] & 1) != 0) v++;
        while((a[h] & 1) == 0) h--;
    }
    Arrays.sort(a, 0, v); // sorterer oddetall på venstre side
    Arrays.sort(a, v, a.length); // sorterer partall på høyreside
  
    }
    // Oppgave 5
    /* 
    Metoden skal "rotere" ên enhet. 
    */
    
    public static void rotasjon(char[] a)
    {
        if(a.length > 1)
        {
            char temp = a[a.length - 1];
            for(int i = a.length - 1; i > 0; i--)
            {
                a[i] = a[i - 1]; // nest siste blir siste                
            }
            a[0] = temp;
        }
    }

    // Oppgave 6
    
   /* 
   Metoden skal "rotere" et valgfritt antall enheter
   */
    
   public static void rotasjon(char[] a, int k)
   {
       int n = a.length; 
       if(n <= 1) return;
       
       k %= n;
       if(k < 0) k += n;
       
      
       snu(a, 0, n - 1); // snur hele tabellen
       //[J, I, H, G, F, E, D, C, B, A]
       snu(a, 0, k - 1); // snur de k første
       //[H, I, J, G, F, E, D, C, B, A]
       snu(a, k, n - 1); // snur resten
       //[H, I, J, A, B, C, D, E, F, G]
   }
   
   // hjelpemetode
   private static void snu(char[] c, int v, int h)
   {
       while (v < h) bytt(c, v++, h--);
   }
   public static void bytt(char[] a, int i, int j)
   {
       char temp = a[i];
       a[i] = a[j];
       a[j] = temp;
   }
   // Oppgave 7 a
   /*
   Metoden skal "flette" sammen tegnstrengene s
   og t slik at resultatet blir en tegnstreng. Der 
   annenhvert tegn kommer fra s og annethvert fra t.
   Hvis s og t har ulik lengde skal resten legges bak
   */
   
   public static String flett(String s, String t)
   {
       char [] c = s.toCharArray();
       char [] d = t.toCharArray();
       
       char [] flett = new char[c.length + d.length];
       
       int m = Math.min(c.length, d.length);
       
       for(int i = 0, j = 0; i < m; i++)
       {
           flett[j++] = c[i] ;
           flett[j++]= d[i];
       }
       
       System.arraycopy(c, m, flett, 2*m, c.length - m);
       System.arraycopy(d, m, flett, 2*m, d.length - m);
       return String.valueOf(flett);
   }
   
   
   // Oppgave 7 b
   /*
   Metoden skal flette sammen tegnstrengene i S. Nå er s en tabell
   av tegnstrenger.
   */
   public static String flett(String... s)
   {
       if(s.length == 0) return "";
       int m = s[0].length();
       
       // finner lengden på den lengste strengen
       for(int i = 1; i < s.length; i++)
       {
           int lengde = s[i].length();
           if(lengde > m) m = lengde;
       }
       
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < m; i++)
       {
           for(String t : s)
           {
               if(i < t.length()) sb.append(t.charAt(i));
           }
       }
       return sb.toString();       
       
   }
   
   //Oppgave 9
   /*
      Metoden skal finne to tall i en sortert liste helltall
      der summen av disse er lik x.
      Dersom det er flere skal vi bare oppgi første
   */
   
   
   public static int[] sumX(int[] a, int x)
   {
       int tall1 = 0;
       int tall2 = 0;
       int[] b = new int[2];
       
       for(int i = 0; i < a.length; i++)
       {
           for(int j = 1; j < a.length; j++)
           {
               if(a[i] + a[j] == x )
               {
                   tall1 = a[i];
                   tall2 = a[j];
                   b[0] = tall2;
                   b[1] = tall1;
               }
           }
       }
       if(b[0] + b[1] < 1)
       {
           System.out.println("Ingen tallpar lik " + x);
           
       }else
       {
           System.out.println("Første tallpar er " + tall + " og " + tall2);
       }
  return b;
   }
   
   
    }
    

