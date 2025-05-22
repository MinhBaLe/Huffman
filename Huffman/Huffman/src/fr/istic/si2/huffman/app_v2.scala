package fr.istic.si2.huffman

import Encodage._
import Decodage._
import ConstructionCode._
import Utils._

/**
 * Application principale V2 : avec construction du code
 */
object HuffmanApp2 extends App {

  /**
   * Une liste de couples caractère / fréquence d'apparition
   * à utiliser par l'application principale.
   */
  // TODO V2
  val lfreqs: List[(Char, Double)] = ('a',0.25)::('b',0.21)::('c',0.18)::('d',0.14)::('e',0.09)::('f',0.07)::('g',0.06)::Nil

  // TODO V2 - A vous de programmer l'application principale
  val h1 = codeHuffman(lfreqs)
  println("Saisir le nom du fichier:")
  val v = nettoyerTexte("Je m'appelle Minh".toList)
  println(v)
  println(enleverDoublon(v))
  println(compteCaractere('l',v))
  println(analyseFrequences("Je m'appelle Minh"))
}