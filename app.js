/*
Lab 009: Ingenieria de Software
Apirest Pacientes en NodeJs
@autor Juan Agustin Apaza Guzman
@version 0.1
@date 26/04/2024
*/
const express = require("express");
const app = express();

app.listen(5000, () => {
    console.log("Servidor escuchando en http://localhost:5000");
});

app.get("/", (req, res) => {
    res.send("Hola mundo \n Juan Agustin Apaza");
});

// Importar PacienteService usando la ruta relativa
const PacienteService = require('./PacienteService');

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
