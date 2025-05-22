package fr.istic.si2.huffman

import Encodage._
import Decodage._
import ConstructionCode._
import Utils._
  
/**
 * Application principale V1 : arbre de code fixé
 */
object HuffmanApp1 extends App {

  /**
   * Arbre de code utilisé par l'application principale
   */
  // TODO V1
  val h: Huffman =  Noeud(1.0,
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
 

               

  // TODO V1 - A vous de programmer l'application principale utilisant l'arbre de code h.
  def mainAppv1(): Unit = {
           var continu : String = ""
             do {
               println("Chaine a encoder ?")
               val input = readLine().toLowerCase
               println("Chaine encodee standard : ")
               println("    " + vers16Bits(input))
               println("    " + "taille (nb Bits) : " + vers16Bits(input).length)
               println("Chaine encodee Huffman : ")
               val e = encode(input,h) 
               println("    " + listBitToString(e))
               println("    " + "taille (nb Bits) : " + e.length)
               println("Chaine decodee Huffman : ")
               println("    " + decode(e,h))
               println("Encore ? [Y/n]")
             }
            while (continu == "Y" || continu == "y")
    }
    mainAppv1()                              
}