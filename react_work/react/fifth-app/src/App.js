import './App.scss';
import Button from './components/Button';

function App() {
  return (
    <div className="App">
      <div className='buttons'>
      <Button size="large">large</Button>
      <Button>기본(medium)</Button>
      <Button size="small">small</Button>
      </div>

      <div className='buttons'>
      <Button size="large" color="gray">large</Button>
      <Button>기본(medium)</Button>
      <Button size="small" color="pink">small</Button>
      </div>

      <div className='buttons'>
      <Button size="large" color="gray" outline>large</Button>
      <Button outline>기본(medium)</Button>
      <Button size="small" color="pink" outline>small</Button>
      </div>
    </div>
  );
}

export default App;
