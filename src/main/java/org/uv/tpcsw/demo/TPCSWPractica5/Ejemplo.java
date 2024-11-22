
package org.uv.tpcsw.demo.TPCSWPractica5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author samantha
 */
@RestController
@RequestMapping("/url")
public class Ejemplo {
    @GetMapping
    public String sayHello(){
        return "Hola mundo!";
    }
}
