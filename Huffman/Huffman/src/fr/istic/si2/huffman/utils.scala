package fr.istic.si2.huffman

import scala.io.Source
import java.io.{ File, PrintWriter }

object Utils {

  /**
   * @param l une liste de bits
   * @return la chaîne de 0 et 1 où chaque bit de l est représenté par 0 ou 1, dans l'ordre
   */
  // TODO V0
  def listBitToString(l: List[Bit]): String = {
    l match {
      case Nil => ""
      case Zero::m => 0 + listBitToString(m)
      case One::m => 1 + listBitToString(m)
    }
  }         
  /**
   * @param s une chaîne de caractères
   * @return la chaîne de 0 et 1 représentant chaque caractère
   *         de s par son encodage sur 16 bits
   */
  def vers16Bits(s: String): String = {
    s.toList.map(c => String.format("%16s", c.toBinaryString).replace(' ', '0')).foldLeft("")((acc, e) => acc + e)
  }

  /**
   * Lit le contenu d'un fichier sur disque.
   *
   * @param nom le nom d'un fichier
   * @return la chaîne contenue dans le fichier nommé nom
   *
   * @note Le nom de fichier peut être indiqué de manière
   *       relative à la racine du projet courant.
   */
  def lireFichier(nom: String): String = {
    val bufferedSource = Source.fromFile(nom)
    val contenu = bufferedSource.getLines.mkString(sys.props("line.separator"))
    bufferedSource.close()
    contenu
  }

  /**
   * Ecrit une chaîne de caractères dans un fichier.
   * Le fichier est écrasé s'il était déjà existant.
   *
   * @param nom le nom du fichier dans lequel on écrit
   * @param contenu la chaîne de caractères à écrire
   *
   * @note Le nom de fichier peut être indiqué de manière
   *       relative à la racine du projet courant.
   */
  def ecrireFichier(nom: String, contenu: String): Unit = {
    val writer = new PrintWriter(new File(nom))
    writer.write(contenu)
    writer.close()
  }

  /**
   * @param s une chaîne de 0 et 1, encodage binaire 16 bits d'un caractère
   * @return le caractère correspondant à s
   */
  def toChar(s: String): Char = {
    Integer.parseInt(s, 2).toChar
  }

  /**
   * @param c un caractère 0 ou 1
   * @return le bit correspondant à c
   */
  def charToBit(c: Char): Bit = {
    c match {
      case '0' => Zero
      case '1' => One
      case _   => sys.error("Unknown bit character: " + c)
    }
  }
  
  /**
   * @param s une chaîne de 0 et 1 uniquement
   * @return la liste de bits correspondant à s
   */
  def stringToListBit(s: String) : List[Bit] = {
    s.toList.map(charToBit)
  }
  
  
}