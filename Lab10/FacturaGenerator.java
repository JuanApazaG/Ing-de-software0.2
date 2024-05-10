/*
Lab 010: Ingenieria de Software
Generar Codigo de Autorizacion de una Factura
@autor Juan Agustin Apaza Guzman
@version 0.1
@date 10/05/2024
*/
import java.math.BigInteger;

public class FacturaGenerator {

    public static void main(String[] args) {
        // Datos de la factura
        String nitEmisor = "123456789";
        String fechaHora = "20190113163721231";
        String sucursal = "0";
        int modalidad = 1;
        int tipoEmision = 1;
        int tipoFactura = 1;
        int tipoDocumentoSector = 1;
        String numeroFactura = "1";
        String pos = "0";
        
        // Paso 1: Completar ceros a la izquierda
        nitEmisor = StringTools.completeCero(nitEmisor, 13, false);
        fechaHora = StringTools.completeCero(fechaHora, 17, false);
        sucursal = StringTools.completeCero(sucursal, 4, false);
        numeroFactura = StringTools.completeCero(numeroFactura, 10, false);
        pos = StringTools.completeCero(pos, 4, false);
        
        // Paso 2: Concatenar los campos
        String cadena = nitEmisor + fechaHora + sucursal + modalidad + tipoEmision + tipoFactura +
                        tipoDocumentoSector + numeroFactura + pos;
        
        // Paso 3: Calcular el dígito de verificación (módulo 11)
        String digitoVerificacion = calculaDigitoMod11(cadena, 1, 9, false);
        
        // Paso 4: Convertir a Base 16
        String codigoAutorizacionBase16 = BaseConverter.Base16(cadena + digitoVerificacion);
        
        // Paso 5: Concatenar con el código de control
        String codigoControl = "87D7B8EE1D88E74"; // Código de control proporcionado
        String codigoAutorizacionFinal = codigoAutorizacionBase16 + codigoControl;
        
        // Imprimir todos los datos de la factura y el código de autorización
        System.out.println("Datos de la factura:");
        System.out.println("Datos de la factura:");
        System.out.println("NIT EMISOR: " + nitEmisor);
        System.out.println("FECHA / HORA: " + fechaHora);
        System.out.println("SUCURSAL: " + sucursal);
        System.out.println("MODALIDAD: " + modalidad);
        System.out.println("TIPO EMISIÓN: " + tipoEmision);
        System.out.println("TIPO FACTURA/DOCUMENTO AJUSTE: " + tipoFactura);
        System.out.println("TIPO DOCUMENTO SECTOR: " + tipoDocumentoSector);
        System.out.println("NÚMERO DE FACTURA: " + numeroFactura);
        System.out.println("POS: " + pos);
        System.out.println("Código de autorización final: " + codigoAutorizacionFinal);
    }

    public static String calculaDigitoMod11(String cadena, int numDig, int limMult, boolean x10) {
        int mult, suma, i, n, dig;
        if (!x10) numDig = 1;
        for(n = 1; n <= numDig; n++) {
            suma = 0;
            mult = 2;
            for(i = cadena.length() - 1; i >= 0; i--) {
                suma += (mult * Integer.parseInt(cadena.substring(i, i + 1)));
                if(++mult > limMult) mult = 2;
            }
            if (x10) {
                dig = ((suma * 10) % 11) % 10;
            } else {
                dig = suma % 11;
            }                   
            if (dig == 10) {
                cadena += "1";
            }
            if (dig == 11) {
                cadena += "0";
            }
            if (dig < 10) {
                cadena += String.valueOf(dig);
            }     
        }
        return cadena.substring(cadena.length() - numDig, cadena.length());
    }
}

class StringTools {
    public static String completeCero(String pString, int pMaxChar, boolean pRight) {
        String vNewString = pString;
        if (pString.length() < pMaxChar) {
            for (int i = pString.length(); i < pMaxChar; i++) {
                vNewString = (pRight) ? vNewString.concat("0") : "0".concat(vNewString);
            }
        }
        return vNewString;
    }
}

class BaseConverter {
    public static String Base16(String pString) {
        BigInteger vValor = new BigInteger(pString);
        return vValor.toString(16);
    }
}
