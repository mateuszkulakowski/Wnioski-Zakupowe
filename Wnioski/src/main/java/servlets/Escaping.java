/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Maciek
 */
 public class Escaping {

public static final String escapeHTML(String s){
   StringBuffer sb = new StringBuffer();
   int n = s.length();
   for (int i = 0; i < n; i++) {
    char c = s.charAt(i);
    switch (c) {
        case 'ą': sb.append("&#261;"); break;
        case 'ć': sb.append("&#263;"); break;
        case 'ę': sb.append("&#281;"); break;
        case 'ł': sb.append("&#322;"); break;
        case 'ń': sb.append("&#324;"); break;
        case 'ó': sb.append("&#243;"); break;
        case 'ś': sb.append("&#347;"); break;
        case 'ź': sb.append("&#378;"); break;
        case 'ż': sb.append("&#380;"); break;
        case 'Ą': sb.append("&#260;"); break;
        case 'Ć': sb.append("&#262;"); break;
        case 'Ę': sb.append("&#280;"); break;
        case 'Ł': sb.append("&#321;"); break;
        case 'Ń': sb.append("&#323;"); break;
        case 'Ó': sb.append("&#211;"); break;
        case 'Ś': sb.append("&#346;"); break;
        case 'Ź': sb.append("&#377;"); break;
        case 'Ż': sb.append("&#379;"); break;

       default: sb.append(c); break;
     }
  }

    return sb.toString();
}
    
}