const Paciente = require('./Paciente.js');

class PacienteService {
    constructor() {
        this.pacientes = [
            new Paciente(1, 'Juan', '1990-01-01'),
            new Paciente(2, 'María', '1985-05-15'),
            new Paciente(3, 'Pedro', '1978-10-30'),
            new Paciente(4, 'Agustin', '2001-11-07')
        ];
    }

    getAllPacientes() {
        return this.pacientes;
    }

    getPacienteById(id) {
        return this.pacientes.find(paciente => paciente.id === id);
    }
}

module.exports = PacienteService;
