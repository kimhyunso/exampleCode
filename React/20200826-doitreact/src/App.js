import React from 'react';

import BooleanComponent from './component/BooleanComponent'



function App() {
  return (
    <div className="App">
        <div><b>지루할 때 :</b><BooleanComponent bored/></div>
        <div><b>즐거울 때 :</b><BooleanComponent/></div>
    </div>
  );
}

export default App;
