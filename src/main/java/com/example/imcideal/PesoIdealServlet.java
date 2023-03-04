package com.example.imcideal;

/*Criar uma classe chamada PesoIdealServlet que na sua execução recebe o sexo
( com as opções “M” ou “F” para Masculino ou Feminino),
 a altura da pessoa e retorna na saída o peso ideal para a pessoa.
        a.	Os cálculos para peso ideal de homem e mulher são os seguintes:
        i.	Para homens = ( 72.7 * altura) - 58;
        ii.	Para mulheres = ( 62.1 * altura) - 44.7;*/

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "IMCIdeal", urlPatterns = "/calcular")
public class PesoIdealServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            Double altura = Double.valueOf(request.getParameter("altura"));
            String sexo = request.getParameter("sexo").toUpperCase();
            Double peso = 0.0;

            if (sexo.equals("M")){
                peso = (72.7 * altura) - 58;
            } else if (sexo.equals("F")) {
                peso = (62.1 * altura) - 44.7;
            }else {
                request.setAttribute("peso", String.format("Sexo deve ser apenas uma letra 'm' ou 'f'."));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

            request.setAttribute("peso", String.format("%.2f ", peso));
            response.setHeader("peso", String.format("%.2f", peso));

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }catch (IllegalArgumentException e){
            request.setAttribute("peso", String.format("Altura deve ser um número real separado por '.' e não ','."));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }
}