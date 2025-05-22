package fr.istic.si2.huffman

import Utils._

object Decodage {

  /**
   * @param h un arbre de Huffman
   * @param l une liste de bits
   * @return caractère correspondant au décodage de l selon h
   *          si l est un chemin valide de h
   */
  // TODO V0
  def decodeSymbolv0(h: Huffman, l: List[Bit]): Option[Char] = {
     (h,l) match{
       case (_,Nil)=> None
       case (Feuille(_,a),_::_)=> None
       case (Feuille(_,a),Nil)=> Some(a)
       case (Noeud(_,g,d),Zero::m)=>decodeSymbolv0(g,m)
       case (Noeud(_,g,d),One::m)=>decodeSymbolv0(d,m)
       
     }
  }

  /**
   * @param h un arbre de Huffman
   * @param l une liste de bits
   * @return un tuple de taille 2
   *         - première composante : caractère correspondant au décodage selon h d'un préfixe de l
   *         - deuxième composante : la liste des bits restant à décoder
   */
  // TODO V1
  def decodeSymbol(h: Huffman, l: List[Bit]): (Option[Char], List[Bit]) = {
     (h,l) match{
       case (_,Nil)=> (None,Nil)
       case (Feuille(_,a),Nil)=>(Some(a),Nil)
       case (Feuille(_,a),_)=>(Some(a),l)
       case (Noeud(_,g,d),Zero::m)=> decodeSymbol(g,m)
       case (Noeud(_,g,d),One::m)=>decodeSymbol(d,m)
         
     }
  }


  /**
   * @param l une liste de bits
   * @param h un arbre de Huffman
   * @return la chaîne correspondant au décodage de l, selon h, si elle existe
   */
  // TODO V1
  def decode(l: List[Bit], h: Huffman): Option[String] = {
      decodeSymbol(h,l) match {
      case (None, _) => Some("")
      case (Some(l),r) =>  decode(r,h)    
       
      }
  }

  /**
   * @param l une liste de bits décrivant, au moins, la représentation binaire d'un arbre de Huffman
   * @return un tuple de taille 2 comprenant :
   *         - l'arbre de code de Huffman reconstruit à partir du début de l
   *         - le reste de la liste l, après la représentation de l'arbre de Huffman
   */
  // TODO V3
  def lireDescription(l: List[Bit]): (Huffman, List[Bit]) = ???
   /* decodeSymbol(Noeud(_,g,d),_::m,l)*/
  /**
   * @param messageEnc une chaîne de 0 et 1 uniquement, contenant la représentation
   *                   d'un arbre de Huffman, puis un message encodé
   * @return le message décodé contenu dans messageEnc, en utilisant le code de huffman
   *         représenté en début de messageEnc
   */
  // TODO V3
  def decode(messageEnc: String): String = ???
    /* decodeSymbol(messageEnc.toString)*/
  
  
      

}