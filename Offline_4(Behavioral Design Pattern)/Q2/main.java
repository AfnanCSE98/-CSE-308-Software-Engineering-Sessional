import java.util.*;
import java.io.*;

public class main {
  public static void main(String[] args) {
      public_service_org jwsa = new public_service_org("JWSA" , "WATER");
      public_service_org jpdc = new public_service_org("JPDC" , "POWER");
      public_service_org jrta = new public_service_org("JRTA" , "TRANSPORT");
      public_service_org jtrc = new public_service_org("JTRC" , "TELECOM");

      mediator_org m_org = new mediator_org(4);

      m_org.add_org(jwsa);
      m_org.add_org(jpdc);
      m_org.add_org(jrta);
      m_org.add_org(jtrc);

      jwsa.set_mediator(m_org);
      jpdc.set_mediator(m_org);
      jrta.set_mediator(m_org);
      jtrc.set_mediator(m_org);

      jwsa.request("POWER");
      jrta.request("POWER");
      jpdc.request("TELECOM");
      jpdc.serve();
      jpdc.serve();
      jpdc.request("WATER");
      jrta.request("WATER");
      jwsa.serve();
      jwsa.serve();
      jtrc.serve();
  }
}
