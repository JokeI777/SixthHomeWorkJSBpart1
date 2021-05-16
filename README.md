ДЗ по теме AOP:   
Реализовать с помощью АОП приложение, которое будет считать количество обращений к АПИ методам и если количество обращений достигнет максимального (задается в конфигурации), то не допускать выполнения АПИ метода.    
Контроллер реализующий АПИ методы:   
```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class ApiController {
 
   private static final Logger log = LoggerFactory.getLogger(ApiController.class);
 
   @GetMapping("/first")
   public String firstApi() {
       log.info("First Api");
       return "first";
   }
 
   @PostMapping("/second")
   public String secondApi() {
       log.info("Second Api");
       return "second";
   }
}
```
