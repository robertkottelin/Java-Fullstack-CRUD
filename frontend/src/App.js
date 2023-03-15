import React, { useState, useEffect } from 'react';

function App() {
  const [numbers, setNumbers] = useState([]);
  // const [inputNumber, setInputNumber] = useState('');

  useEffect(() => {
    fetchNumbers();
  }, []);

  const fetchNumbers = async () => {
    try {
      const response = await fetch('http://localhost:3000/api/numbers');
      setNumbers(response.data);
    } catch (error) {
      console.error('Error fetching numbers:', error);
    }
  };

  // const handleAddNumber = async () => {
  //   if (inputNumber) {
  //     try {
  //       await post('http://localhost:3000/api/numbers', { number: inputNumber });
  //       setInputNumber('');
  //       fetchNumbers();
  //     } catch (error) {
  //       console.error('Error adding number:', error);
  //     }
  //   }
  // };

  return (
    <div className="App">
      <h1>Numbers</h1>
      <ul>
        {numbers.map((item) => (
          <li key={item.id}>{item.number}</li>
        ))}
      </ul>
      <div>
        {/* <input
          type="number"
          value={inputNumber}
          onChange={(e) => setInputNumber(e.target.value)}
        />
        <button onClick={handleAddNumber}>Add Number</button> */}
      </div>
    </div>
  );
}

export default App;
