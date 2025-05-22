package fr.istic.si2.huffman

import Utils._

object Encodage {

  /**
   * @param c un caractère
   * @param h un arbre de Huffman
   * @return l'encodage de c, selon h (si c est bien présent dans h)
   */
  // TODO V0
  def encodeSymbol(c: Char, h: Huffman): Option[List[Bit]] ={
     (c,h) match {
      case (a, Feuille(_,b)) => if (a == b) Some(Nil) else None
      case (a, Noeud(_, b, c)) =>
        val x = encodeSymbol(a, b)
        val y = encodeSymbol(a, c)
        (x, y) match {
          case (None, Some(l)) => Some(One::l)
          case (Some(l), _) => Some(Zero::l)
          case _ => None
        }
     }
  }
  /**
   * @param l une liste de caractères
   * @param h un arbre de Huffman
   * @return la séquence de bits correspondants à
   *         l'encodage selon h des éléments de l, s'il a réussi.
   *         Les caractères pour lesquels l'encodage est impossible sont oubliés
   */
  // TODO V1
  def encodeList(l: List[Char], h: Huffman): List[Bit] = {
     l match {
      case Nil => Nil
      case m :: n =>  (encodeSymbol(m,h)) match {
                        case None => encodeList(n,h)
                        case Some(s) => s ++ encodeList(n,h)
      }
     }
  }

  /**
   * @param s une chaîne de caractères
   * @param h un arbre de Huffman
   * @return l'encodage de s, selon h, en une liste de bits.
   *         (concaténation de l'encodage de chaque caractère de s selon h)
   */
  // TODO V1
  def encode(s: String, h: Huffman): List[Bit] = {
     encodeList(s.toList,h)
  }
    

  /**
   * @param h un arbre de Huffman
   * @return une chaîne de 0 et 1 uniquement représentant l'arbre h (voir partie 1.3 de l'énoncé)
   *         Les caractères encodables avec h sont représentés dans leur encodage binaire 16 bits.
   */
  // TODO V3
  def descriptionHuffman(h: Huffman): String = ???
    /* encodeList(h.toString)*/
  
  /**
   * @param message une chaîne de caractères
   * @return la chaîne de 0 et 1, contenant:
   *         - la représentation de l'arbre de huffman construit à partir de message
   *         - puis l'encodage de message en utilisant l'arbre construit à partir de message
   */
  // TODO V3
  def encode(message: String): String = ???
    /* encodeList(message.toString)*/
  
}

