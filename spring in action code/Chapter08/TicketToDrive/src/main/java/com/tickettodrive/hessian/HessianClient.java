package com.tickettodrive.hessian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tickettodrive.Citation;
import com.tickettodrive.CitationService;

public class HessianClient {
   public static void main(String[] args) {
      ApplicationContext ctx = new ClassPathXmlApplicationContext(
                        "ttd-hessian-client.xml");

      CitationService cs = (CitationService) ctx.getBean("citationService");

      Citation[] citations = cs.getCitationsForVehicle("TX", "J55DNY");

      for (int i = 0; i < citations.length; i++) {
         Citation citation = citations[i];
         System.out.println(i + ".  " + citation.getViolationCode() + " - "
                           + citation.getDescription());
      }
   }
}
