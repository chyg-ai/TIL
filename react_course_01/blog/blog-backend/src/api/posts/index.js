import Router from 'koa-router';
import * as postsCtrl from './posts.ctrl';

const posts = new Router();

// 미들웨어 함수

posts.get('/', postsCtrl.list);
posts.post('/', postsCtrl.write);
posts.get('/:id', postsCtrl.read);
posts.delete('/:id', postsCtrl.remove);
posts.patch('/:id', postsCtrl.update);

export default posts;
