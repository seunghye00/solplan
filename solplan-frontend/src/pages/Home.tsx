import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Home = () => {

  const navigate = useNavigate();

    useEffect(() => {
      const userId = localStorage.getItem('userId');
      if (!userId) {
        alert('로그인이 필요합니다.');
        navigate('/');
      }
    }, []);

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>메인페이지</h2>
      <button onClick={() => {localStorage.clear(); alert('로그아웃되었습니다.'); navigate('/');}}>
        로그아웃
      </button>
    </div>
  );
};

export default Home;