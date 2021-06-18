import java.util.*;
import java.io.*;

public class main {
  public static void main(String[] args) {
      org jwsa_ = new jwsa("WATER");
      org jpdc_ = new jpdc("POWER");
      org jrta_ = new jrta("TRANSPORT");
      org jtrc_ = new jtrc("TELECOM");

      mediator_org m_org = new mediator_org(4);

      m_org.add_org(jwsa_);
      m_org.add_org(jpdc_);
      m_org.add_org(jrta_);
      m_org.add_org(jtrc_);

      jwsa_.request("POWER");
      jrta_.request("POWER");
      jpdc_.request("TELECOM");
      jpdc_.serve();
      jpdc_.serve();
      jpdc_.request("WATER");
      jrta_.request("WATER");
      jwsa_.serve();
      jwsa_.serve();
      jtrc_.serve();
  }
}
