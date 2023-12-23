package my.emasjid.cadanganapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.emasjid.cadanganapi.entity.Cadangan;
import my.emasjid.cadanganapi.service.CadanganService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("${deploy.url}")
public class CadanganController {

    @Autowired
    private CadanganService cadanganService;

    @GetMapping("/cadangan")
    @ResponseBody
    public ResponseEntity<Page<Cadangan>> getAllCadangan(@RequestParam int page,
    @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);

        try {
            return ResponseEntity.ok(cadanganService.getAllCadangan(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
    
    @PostMapping("/cadangan")
    public ResponseEntity<Cadangan> createCadangan(@RequestBody Cadangan cadangan) {
        try {
            return ResponseEntity.ok(cadanganService.save(cadangan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/cadangan/{id}")
    public ResponseEntity<Cadangan> putMethodName(@PathVariable Long id, 
    @RequestBody Cadangan cadangan) {
        try {
            return ResponseEntity.ok(cadanganService.save(cadangan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}