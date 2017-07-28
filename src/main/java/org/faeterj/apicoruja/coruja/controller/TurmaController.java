package org.faeterj.apicoruja.coruja.controller;

import java.util.List;
import org.faeterj.apicoruja.coruja.controller.requestBody.TurmaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by William Lemos on 23/07/17.
 */
@RestController
public class TurmaController {
	
    private TurmaService service;

    @Autowired
    public TurmaController (TurmaService service) {
        this.service = service;
    }

    @GetMapping(value="/turma")
    public List<Turma> listarTurma ( ) {
        return service.obterTodasTurmas ( );
    }
    
    @GetMapping(value="/turma/codigo/{codigo}")
    public Turma listarTurmaCodigo (@RequestBody String codigo) {
        return service.obterTurmaCodigo (codigo);
    }
    
    @GetMapping(value="/turma/turno/{char}")
    public List<Turma> listarTurmaTurno (@RequestBody char turno) {
        return service.obterTurmasTurno (turno);
    }

    @PostMapping(value="/turma")
    public boolean adicionarTurma (@RequestBody TurmaRequestBody requestBody) {
        return service.adicionarTurma (new Turma (requestBody));
    }

    @DeleteMapping(value="/turma")
    public boolean removerTurma (@RequestBody TurmaRequestBody requestBody) {
    	return service.removerTurma (new Turma (requestBody));
    }

    @PutMapping(value="/turma")
    public void alterarTurma (@RequestBody TurmaRequestBody requestBodyOriginal, TurmaRequestBody requestBodyAlterar) {
    	Turma original = new Turma (requestBodyOriginal);
    	Turma alterar  = new Turma (requestBodyAlterar);

    	service.alterarTurma (original, alterar);
    }

}

// OK