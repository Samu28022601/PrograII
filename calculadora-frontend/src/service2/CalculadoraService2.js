
import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const sumar = async (a, b) => {
    return { data: a + b };
};

export const restar = async (a, b) => {
    return { data: a - b };
};

export const multiplicar = async (a, b) => {
    return { data: a * b };
};

export const dividir = async (a, b) => {
    if (b === 0) {
        throw new Error('Division by zero');
    }
    return { data: a / b };
};

export const obtenerHistorial = async () => {
    // Simulación de una llamada a un servicio para obtener el historial
    return { data: [] };
};

