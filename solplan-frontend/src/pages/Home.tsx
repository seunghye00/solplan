import { useNavigate } from 'react-router-dom';

const Home = () => {

  const navigate = useNavigate();

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>메인페이지</h2>
      <button onClick={() => navigate('/')}>
        뒤로가기
      </button>
    </div>
  );
};

export default Home;