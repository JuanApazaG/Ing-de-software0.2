const express = require('express');
const PacienteService = require('../PacienteService');

const app = express();
const pacienteService = new PacienteService();

app.get('/pacientes', (req, res) => {
    const pacientes = pacienteService.getAllPacientes();
    res.json(pacientes);
});

app.get('/pacientes/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const paciente = pacienteService.getPacienteById(id);
    if (paciente) {
        res.json(paciente);
    } else {
        res.status(404).send('Paciente no encontrado');
    }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Servidor en ejecución en el puerto ${PORT}`);
});
