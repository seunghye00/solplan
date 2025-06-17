import { useNavigate } from 'react-router-dom';

const Admin = () => {

  const navigate = useNavigate();

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>관리자 페이지</h2>
      <button onClick={() => navigate('/')}>
        뒤로가기
      </button>
    </div>
  );
};

export default Admin;