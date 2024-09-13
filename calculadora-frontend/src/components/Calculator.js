import React, { useState, useEffect } from 'react';
import Button from './Button';
import Display from './Display';
import History from './History';
import { sumar, restar, multiplicar, dividir, obtenerHistorial } from '../service2/CalculadoraService2';

const Calculator = () => {
    const [value, setValue] = useState('');
    const [history, setHistory] = useState([]);

    useEffect(() => {
        const fetchHistorial = async () => {
            try {
                const response = await obtenerHistorial();
                setHistory(response.data);
            } catch (error) {
                console.error('Error fetching historial:', error);
            }
        };

        fetchHistorial();
    }, []);

    const handleButtonClick = async (label) => {
        if (label === '=') {
            try {
                const [a, operator, b] = value.trim().split(' ');
                console.log(`a: ${a}, operator: ${operator}, b: ${b}`); // Depuración

                // Convertir a y b a números
                const numA = parseFloat(a);
                const numB = parseFloat(b);

                if (isNaN(numA) || isNaN(numB) || !operator) {
                    setValue('Error');
                    return;
                }

                let result;
                switch (operator) {
                    case '+':
                        result = await sumar(numA, numB);
                        break;
                    case '-':
                        result = await restar(numA, numB);
                        break;
                    case '*':
                        result = await multiplicar(numA, numB);
                        break;
                    case '/':
                        result = await dividir(numA, numB);
                        break;
                    default:
                        setValue('Error');
                        return;
                }
                console.log(result.data); // Verifica la respuesta del servidor
                setValue(result.data);
                const response = await obtenerHistorial();
                setHistory(response.data);
            } catch (error) {
                console.error('Error during calculation:', error); // Depuración
                setValue('Error');
            }
        } else if (label === 'C') {
            setValue('');
        } else {
            setValue(value + ' ' + label);
        }
    };

    return (
        <div className="calculator">
            <Display value={value} />
            <div className="buttons">
                {['1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', '0', 'C', '=', '/'].map((label) => (
                    <Button key={label} label={label} onClick={handleButtonClick} />
                ))}
            </div>
            <History history={history} />
        </div>
    );
};

export default Calculator;
