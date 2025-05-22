package fr.istic.si2.huffman

import Encodage._
import Decodage._
import Utils._

/**
 * Application principale V0 : arbre de code fixé, encodage/décodage de caractères
 */
object HuffmanApp0 extends App {

  /**
   * Arbre de code utilisé par l'application principale
   */
  // TODO V0
  val h: Huffman = Noeud(1.0,
                        Noeud(0.57,
                            Feuille(0.25,'a'),
                            Noeud(0.32,
                                Feuille(0.18,'c'),
                                Feuille(0.14,'d'))),                        
                        Noeud(0.43,
                            Feuille(0.21,'b'),
                            Noeud(0.22,
                                Noeud(0.13,
                                  Feuille(0.07,'f'),   
                                  Feuille(0.06,'g')),    
                                Feuille(0.09,'e'))))

  // TODO V0 - A vous de programmer l'application principale utilisant l'arbre de code h
   def mainApp(): Unit = {
     for (a <- 'a' to 'z') {
       val encode = encodeSymbol(a, h)
       val encodeToString = 
          encode match {
               case None => "_"
               case Some(l) => listBitToString(l)
             }
       val decode = 
           encode match {
             case None => None
             case Some(l) => decodeSymbolv0(h, l)
           }
       val decodeToString = 
         decode match {
                 case None => "_"
                 case Some(c) => c
               }
       println(a + "  " + encode + "  " + encodeToString + "  " + decodeToString)
       
     }
     
 }
  mainApp()

 
}